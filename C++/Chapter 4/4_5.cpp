#include <iostream>
using namespace std;

int main () {
    int d1,r1, d2,r2, s1,s2;

    cout <<"Input the legth and width of 1st rectangle: "; cin >>d1 >>r1;
    cout <<"Input the legth and width of 2nd rectangle: "; cin >>d2 >>r2;
    s1=d1*r1;
    s2=d2*r2;
    if (s1 > s2){
        cout <<"area's 1st greater than 2nd." <<endl;
        } else if (s1 < s2) {
        cout <<"area's 2nd greater than 1st." <<endl;
            } else if (s1 = s2)
        cout <<"The areas are the same." <<endl;
    return 0;
}