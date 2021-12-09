#include <iostream>
using namespace std;

int main()
{
    int x, y, A, B, C, D, E;

    cout <<"Enter the value x: ";
    cin >> x;
    cout <<"Enter the value y: ";
    cin >> y;

    cout <<"A=y+3= " << y+3 <<endl; 
    cout <<"B=y-2= " << y-2 <<endl; 
    cout <<"C=y*5= " << y*5 <<endl;

    if (y==0) {
        cout <<"D=x/y is undefined" <<endl;
        cout <<"E=x%y is undefined" <<endl;
    } else {
        cout <<"D=x/y= " << float(x/y) <<endl;
        cout <<"E=x%y= " << x%y <<endl;
    }

    return 0;
}