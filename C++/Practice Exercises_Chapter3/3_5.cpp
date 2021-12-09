#include <iostream>
using namespace std;

int main()
{
    int t;
    float v0, a;

    cout <<"Enter initial velocity value: ";
    cin >> v0;
    cout <<"Enter acceleration value: ";
    cin >> a;
    cout <<"Enter initial time value: ";
    cin >> t;
    
    cout <<"The final velocity = " << v0+a*t;
    
    return 0;
}