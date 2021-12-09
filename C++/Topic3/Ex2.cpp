#include<iostream>
using namespace std;

int main() 
{
    float C,F;
    cout <<"Enter the the temperature of degrees Celsius: ";
    cin >> C;
    F=(9*C)/5+32;
    cout <<"The temperature of degrees Fahrenheit after conversion is " << F;
    return 0;
}