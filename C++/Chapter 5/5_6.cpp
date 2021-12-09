#include <iostream>

using namespace std;

int main() {

    int n;
    
    cout <<"Input a natural number= "; cin >>n;
    if (n<0) cout <<"Please input a number >=0.";
    else 
    for (int i=n; i>=1; i--)
    cout <<i <<" ";

    return 0;
}