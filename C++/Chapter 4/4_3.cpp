#include <iostream>
using namespace std;

int main () {
    int month, day, year;
    
    cout <<"Enter (in numeric form) a month, a day, and a two-digit year, \n";
    cout <<"and the program will determin if the date is magic. \n";
    cout <<"Enter a month: ";
    cin >> month;
    cout <<"Enter a day: ";
    cin >> day;
    cout <<"Enter a two-digit year: ";
    cin >> year;

    if (year == month*day)
        cout <<"The date is magic. \n";
    else
        cout <<"The date is not magic. \n";
    return 0;
}