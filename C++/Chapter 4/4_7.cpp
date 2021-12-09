#include <iostream>
#include <cmath>
using namespace std;

int main () {
    float value;
    int cur2;
    cout <<"Enter US Dollar= "; cin >>value;
    cout << "Please choose the currency you wish to convert to: ";
    cin >> cur2;
        switch (cur2){
        case 1:cout <<"Euro= " <<value*0.86; break;
        case 2:cout <<"Japanese Yen= " <<value*113.15; break; 
        case 3:cout <<"British Pound= " <<value*0.74; break;
        case 4:cout <<"Vietnamese Dong= " <<value*22660.0; break;
    }
    return 0;
}