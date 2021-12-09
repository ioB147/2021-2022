#include <iostream>
#include <cmath>
#include <math.h>
using namespace std;

int main()
{
    int x, y;
    float p, s, q;

    cout <<"Input two integers x, y: ";
    cin >> x;
    cin >> y;

    p=x*y;
    s=x+y;
    q=s*2+p*(s*x)*(p+y);
    cout <<"p= " << p <<endl;
    cout <<"s= " << s <<endl;
    cout <<"q= " << q <<endl;
    
    return 0;
}