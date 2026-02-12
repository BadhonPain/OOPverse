#include<iostream>
#include<cstring>
using namespace std;

class String
{
    int size = 80;
    char charArray[80];
    public:
    String()
    {
        strcpy(charArray," ");
    }


};

int main()
{
String s1 = "\nMerry Christmas!  ";   //uses constructor 2
String s2 = "Happy new year!";        //uses constructor 2
String s3;                            //uses constructor 1
s1.display();                         //display strings
s2.display();
s3.display();
s3 = s1 + s2;                         //add s2 to s1,
//assign to s3
s3.display();                         //display s3
cout << endl;
return 0;
}