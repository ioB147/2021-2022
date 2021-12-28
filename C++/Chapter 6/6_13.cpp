#include <iostream>
#include <cmath>
using namespace std;

void swappointer(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
    cout <<"a =" <<*a <<"\nb= " <<*b;
}
int main()
{   
    int a,b;

    cout <<"a= "; cin >>a;
    cout <<"b= "; cin >>b;
    cout <<"\tAfter swaping\n";
    swappointer(&a,&b);
}