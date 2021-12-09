#include <iostream>
#include <cmath>
using namespace std;

int main() {

    int m,n;
    int r,t,sum,mm,num;

    cout <<"Enter number m: "; cin >>m;
    cout <<"Enter number n: "; cin >>n;

    cout <<"Armstrong numbers from " <<m <<" and " <<n <<" are: ";
    
      for (num = m; num <= n; num++) 
    {
        t = num;
        sum = 0;
        while (t != 0) 
        {
            r = t % 10;
            mm = pow(r, 3);
            sum = sum + mm;
            t = t / 10;
        }
        if (sum == num)
            cout << num << " ";
    }

    return 0;
}