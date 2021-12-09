#include <iostream>
using namespace std;

void Reorder(int n) {
    int a, b, c, d;
    int tmp;
    a = n%10;
    n /= 10;
    b = n%10;
    n /= 10;
    c = n%10;
    n /= 10;
    d = n%10;
    if (a > b) {tmp = a; a = b; b = tmp;}
    if (c > d) {tmp = c; c = d; d = tmp;}
    if (a > c) {tmp = a; a = c; c = tmp;}
    if (b > d) {tmp = b; b = d; d = tmp;}
    if (b > c) {tmp = b; b = c; c = tmp;}
    cout << "ASC(x) = " << a << b << c << d << "\n";
    cout << "DESC(x) = " << d << c << b << a;
    return;
}

int main()
{
    int n;
    cout <<"X = "; cin >>n;
    Reorder(n);
}