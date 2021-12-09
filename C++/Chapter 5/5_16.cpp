#include <iostream>
using namespace std;
 
int main() {

    int n,num=0,i,residual,count=0;
    do
    {
    cout <<"Enter a positive integer: "; cin >>n;
    } while (n<1);

    while (n != 0) //reserve order
    {
        num = (num * 10) + (n % 10); 
        n /= 10; 
    }

    while (num != 0)
    {
        residual = num % 10;
        if (residual % 2 != 0)
        {
            cout <<residual;
            count++;
        }
        num = num / 10;
    }

    if (count == 0)
        cout <<"N";

    return 0;
}