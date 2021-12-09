#include<iostream>
using namespace std;

int main() 
{
    double USD, YEN_PER_DOLLAR, EUROS_PER_DOLLAR;
    YEN_PER_DOLLAR=131.61;
    EUROS_PER_DOLLAR=0.86;
    cout <<"Enter U.S. dollar: ";
    cin >> USD;
    cout <<"Convert U.S. dollar amounts to Japanese yen= " <<USD*YEN_PER_DOLLAR <<endl;
    cout <<"Convert U.S. dollar amounts to euros= " <<USD*EUROS_PER_DOLLAR <<endl;
    return 0;    
}