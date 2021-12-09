#include <iostream>
using namespace std;
 
int main() {

    int n,sum=0,i=0,largest;

    cout <<"Enter a positive integer n: "; cin >>n;
    if (n>0)
    {
        while (sum <= n)
        {
            i++;
            sum+=i;
        }
        largest = i-1;
        cout <<largest;
    }
    else cout <<"N";

    return 0;
}