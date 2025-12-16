#include <stdio.h>
typedef struct xxx
{
    int roll;
    char name[20];
    double cgpa;
} Student;

int main()
{
    Student s1;
    printf("Enter students name: ");
    gets(s1.name);
    printf("Enter students roll: ");
    scanf("%d", &s1.roll);
    printf("Enter students cgpa: ");
    scanf("%lf", &s1.cgpa);
    printf("Name: %s\n", s1.name);
    printf("Roll: %d\n", s1.roll);
    printf("CGPA: %.2lf\n", s1.cgpa);

    return 0;
}