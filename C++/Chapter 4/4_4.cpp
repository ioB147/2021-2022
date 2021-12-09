#include <iostream>
using namespace std;

int main () {
    int a,b,c;

    cout <<"Input 1st angle: "; cin >>a;
    cout <<"Input 2nd angle: "; cin >>b;
    cout <<"Input 3rd angle: "; cin >>c;
    if ((a+b+c)==180 && 0<a<=180 && 0<b<180 && 0<c<=180)
        cout <<"Valid!";
    else 
        cout <<"Not valid!";
    return 0;
}