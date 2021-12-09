#include <iostream>
using namespace std;

int digitNumber(int n) 
{
    int c = 1;
    while (n / 10 != 0) 
    {
        n /= 10;
        c++;
    }
    return c;
}

int digitFactor(int n) 
{
    int digitf = 0;
    for(int i = 2; i <= n; i++) 
    {
        int c = 0;
        if (n % i == 0) digitf++;
        while (n%i == 0) 
        {
            n /= i;
            c++;
        }
        if (c > 1) 
        {
            digitf++;
            while (c/10 != 0) {
                c /= 10;
                digitf++;
            }
        }
    }
    return digitf;
}

bool checkPrime(int n) 
{
    for (int i = 2; i < n/2; i++) 
    {
        if (n % i == 0) return false;
    }
    return true;
}

int EconomicalNumber(int n) 
{
    int fd = digitFactor(n);
    int nd = digitNumber(n);
    if (checkPrime(n) || fd == nd) return 1;
    if (fd < nd) return 2;
    return 3;
}
int main()
{
    int n;
    cout <<"Input n= "; cin >>n;
    cout <<EconomicalNumber(n);
    return 0;
}