#include <iostream>
#include <cmath>
using namespace std;

static int findfact(int num, int *fact)
{
    int i;
    *fact = 1;
    for (i=1; i <= num; i++)
    (*fact)*=i;
    return *fact;
}

int main()
{
    int i,fact,num;
    cout <<"Enter a number: "; cin >>num;
    cout <<findfact(num, &fact);
    return 0;
}