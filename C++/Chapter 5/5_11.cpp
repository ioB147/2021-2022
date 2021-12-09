#include <iostream>
#include <math.h>
using namespace std;
int main() {
    
    int n, num = 0, i, digit;
    cout << "\nEnter any number: ";
    cin >> n;

    while (n != 0) //reserve order
    {
        num = (num * 10) + (n % 10); 
        n /= 10; 
    }
    while (num > 0)
    {
        digit = num%10;
        num /=10;
        switch (digit) 
        {
        case 0:
            cout << "Zero ";
            break;
        case 1:
            cout << "One ";
            break;
        case 2:
            cout << "Two ";
            break;
        case 3:
            cout << "Three ";
            break;
        case 4:
            cout << "Four ";
            break;
        case 5:
            cout << "Five ";
            break;
        case 6:
            cout << "Six ";
            break;
        case 7:
            cout << "Seven ";
            break;
        case 8:
            cout << "Eight ";
            break;
        case 9:
            cout << "Nine ";
            break;
        }
    }

    return 0;
}