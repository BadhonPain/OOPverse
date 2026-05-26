#if defined(__MINGW32__) && !defined(_GLIBCXX_HAS_GTHREADS)
#include <iostream>
using namespace std;
int main() {
    cout << "[NOTE] MinGW with win32 threads detected." << endl;
    cout << "Recompile with: g++ -std=c++17 -pthread (posix thread model)" << endl;
    return 0;
}
#else

#include <iostream>
#include <thread>
#include <mutex>
#include <vector>
#include <chrono>
#include <condition_variable>
#include <queue>
using namespace std;

mutex coutMutex;

void safePrint(const string& msg) {
    lock_guard<mutex> lock(coutMutex);
    cout << msg << endl;
}

void basicTask(int id) {
    safePrint("  Thread " + to_string(id) + " started (ID: " +
              to_string(hash<thread::id>{}(this_thread::get_id()) % 10000) + ")");
    this_thread::sleep_for(chrono::milliseconds(100 * id));
    safePrint("  Thread " + to_string(id) + " finished");
}

// Shared counter with mutex protection
class Counter {
    int value = 0;
    mutex mtx;
public:
    void increment(int times) {
        for (int i = 0; i < times; i++) {
            lock_guard<mutex> lock(mtx);
            value++;
        }
    }
    int get() const { return value; }
};

// Producer-consumer with condition variable
class ProducerConsumer {
    queue<int> buffer;
    const int maxSize = 5;
    mutex mtx;
    condition_variable notFull, notEmpty;
    bool done = false;

public:
    void produce(int count) {
        for (int i = 1; i <= count; i++) {
            unique_lock<mutex> lock(mtx);
            notFull.wait(lock, [this]{ return buffer.size() < (size_t)maxSize; });
            buffer.push(i);
            safePrint("  Produced: " + to_string(i) + " (buffer size: " + to_string(buffer.size()) + ")");
            lock.unlock();
            notEmpty.notify_one();
            this_thread::sleep_for(chrono::milliseconds(50));
        }
        lock_guard<mutex> lock(mtx);
        done = true;
        notEmpty.notify_all();
    }

    void consume() {
        while (true) {
            unique_lock<mutex> lock(mtx);
            notEmpty.wait(lock, [this]{ return !buffer.empty() || done; });
            if (buffer.empty() && done) break;
            int val = buffer.front();
            buffer.pop();
            safePrint("  Consumed: " + to_string(val) + " (buffer size: " + to_string(buffer.size()) + ")");
            lock.unlock();
            notFull.notify_one();
            this_thread::sleep_for(chrono::milliseconds(80));
        }
    }
};

int main() {
    cout << "=== Basic Thread Creation & Join ===" << endl;
    vector<thread> threads;
    for (int i = 1; i <= 4; i++) {
        threads.emplace_back(basicTask, i);
    }
    for (auto& t : threads) {
        t.join();
    }

    cout << "\n=== Lambda Threads ===" << endl;
    thread t1([]{ safePrint("  Lambda thread A running"); });
    thread t2([]{ safePrint("  Lambda thread B running"); });
    t1.join();
    t2.join();

    cout << "\n=== Mutex-Protected Counter ===" << endl;
    Counter counter;
    vector<thread> workers;
    for (int i = 0; i < 4; i++) {
        workers.emplace_back(&Counter::increment, &counter, 10000);
    }
    for (auto& w : workers) {
        w.join();
    }
    cout << "  Final counter value: " << counter.get()
         << " (expected: 40000)" << endl;

    cout << "\n=== Producer-Consumer Pattern ===" << endl;
    ProducerConsumer pc;
    thread producer(&ProducerConsumer::produce, &pc, 8);
    thread consumer(&ProducerConsumer::consume, &pc);
    producer.join();
    consumer.join();

    cout << "\n=== Thread with Return Value (via reference) ===" << endl;
    int result = 0;
    thread calcThread([&result]{
        int sum = 0;
        for (int i = 1; i <= 100; i++) sum += i;
        result = sum;
    });
    calcThread.join();
    cout << "  Sum of 1..100 = " << result << endl;

    cout << "\nAll threads completed successfully!" << endl;
    return 0;
}

#endif
