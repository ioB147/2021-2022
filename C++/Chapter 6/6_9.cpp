#include <iostream>
#include <cmath>
using namespace std;

static bool isPrime(int n) 
{
 for (int i = 2; i < n; i++) 
    {
        if (n % i == 0) return false;
    }
return true;
}

static int countPrime(int k) 
{
    int count = 2;
    int x = 3;
    int primesFound = 1;
while (primesFound != k) 
{
  if (isPrime(x)) 
    {
        count = count * x;
        primesFound++;
    }
    
    x++;
}
return count;
}

int main()
{
    int n;
    cout <<"n= "; cin >>n;
    cout <<countPrime(n);
    return 0;
}