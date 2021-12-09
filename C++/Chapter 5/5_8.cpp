#include <iostream>

using namespace std;

int main() {

    int n, s=1;

    cout <<"Input a natural number: "; cin >> n;
    int i=n;
    while (i!=0) 
    {
        s*= i % 10;
        i /= 10;
    }
    cout <<"The product of " <<n <<" = " <<s;
    return 0;
}