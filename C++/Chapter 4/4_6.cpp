#include <iostream>
#include <cmath>
using namespace std;

int main () {
    float a,b,c, d;

    cout <<"Input a, b ,c= "; cin >>a >>b >>c;

    if (a == 0) {
        if (b == 0) {
            cout<<"Phuong trinh vo nghiem!";
        } else {
            cout<<"Phuong trinh co mot nghiem: x = "<<-c / b;
        }
    } else {
    cout <<a <<"x^2 + " <<b <<"x + " <<c <<endl;

    d=b*b-4*a*c;

    if (d<0){
        cout <<"no roots";
        } else if (d=0) {
            cout <<"Root1 = Root2 =" <<-b/(2*a) <<endl;
        } else {
            cout <<"Root1= " <<(-b+sqrt(d))/2*a <<endl;
            cout <<"Root2= " <<(-b-sqrt(d))/2*a <<endl;
        }
    }
    return 0;
}