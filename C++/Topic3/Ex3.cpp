#include<iostream>
#include <math.h>
using namespace std;

int main() 
{
    double angle;

    cout <<"Input an angle in radians= ";
    cin >> angle;
    cout <<"sin(" <<angle<<")= " << sin(angle) <<endl;
    cout <<"cos(" <<angle<<")= " << cos(angle) <<endl;
    cout <<"tan(" <<angle<<")= " << tan(angle) <<endl;
    return 0;    
}