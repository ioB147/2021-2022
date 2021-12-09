#include <iostream>
using namespace std;

int main()
{
    int x, du, nguyen;

    cout <<"Enter a two-digit number: ";
    cin >> x;

    nguyen=x/10;
    du=x%10;

    cout <<"Total of two digits of " << x <<" = " <<nguyen+du <<endl;

    return 0;

}