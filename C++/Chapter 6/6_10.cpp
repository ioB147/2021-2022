#include <iostream>
#include <cmath>
using namespace std;

int findDitgits(int n)
{
    int i = 1;
    while (n/10 != 0) 
    {
        n /= 10;
        i++;
    }
    return i;
}

bool polydivisibleNumber(int n) 
{
    for (int i = findDitgits(n)-1; i >= 0; i--)
    {
        int t = (int)n/pow(10, i);
        if (t % (findDitgits(n) - i) != 0) return false;
    }
    return true;
}

int main()
{
    int n;
    cout <<"Enter a number: "; cin >>n;
    if (polydivisibleNumber(n))
    cout <<n <<" is Polydivisible number.";
    else
    cout <<"False.";
}