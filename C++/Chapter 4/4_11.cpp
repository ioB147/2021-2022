#include <iostream>
#include <algorithm>
using namespace std;

int main () {
    int a,b,c;

    cout <<"Input all sides of a triangle: "; cin >>a >>b >>c;
    if (a<=0 && b<=0 && c<=0){
        cout <<"Not triangle";
    } else 
    if(a==b && a!=c && b!=c || a==c && a!=b && c!=b || b==c && b!=a && c!=a)
        cout <<"I";
    if (a==b && b==c & c==a) 
        cout <<"E";
    if (a!=b && b!=c && c!=a) 
        cout<<"S";
    return 0;
}