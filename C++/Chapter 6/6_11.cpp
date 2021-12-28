#include <iostream>
#include <cmath>
using namespace std;

float area(float *value)
{
    return 3.14 * (*value) * (*value);
}

int main()
{
    float r;
    cout <<"Input the radius of Circle: "; cin >>r;
    cout <<"area= " <<area(&r);
    return 0;
}