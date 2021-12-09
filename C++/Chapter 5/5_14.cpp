#include <iostream>
#include <math.h>
using namespace std;
int main() {
    
    int n=0, k, sum = 0;
    int choosing, number;
    char finishProgram;


    reselect: // label goto
    cout << endl;
    cout << "====================" << endl;
    cout << "\tMenu" << endl;
    cout << " 1. Armstrong" << endl;
    cout << " 2. Prime" << endl;
    cout << " 3. Finish" << endl;
    cout << "====================" << endl;
    cout << "Choose (1,2,3): ";
    cin >> choosing;
    

    switch (choosing)
    {
    case 1:
        cout << "Enter the number to if the number is Armstrong Number or not: ";
        cin >> number;

        
        k = number;
        while (number >= 1)
        {
            int residual = number % 10;
            sum += pow(residual ,3);
            number /= 10; 
        }
        if (k == sum)
        {
            cout << k << " is Armstrong number." << endl;
        }
        else
        {
            cout << k << " is not Armstrong number." << endl;
        }

        
        cout << "Do you want to finish (c/k)? ";
        cin >> finishProgram;
        break;
    case 2:
        cout << "Enter the number to if the number is Prime Number or not: ";
        cin >> number;

        
        for (int i = 2; i < number; i++)
        {
            if (number % i == 0)
            n++;
        }
        if (n == 0)
        {
            cout << number << " is Prime number" << endl;
        }
        else
        {
            cout << number << " is not Prime number" << endl;    
        }

        
        cout << "Do you want to finish (c/k)? ";
        cin >> finishProgram;
        break;
    case 3:
        cout << "Do you want to finish (c/k)? ";
        cin >> finishProgram;
        break;
    }

    // GOTO 
    // finishProgram
    if (finishProgram == 'k')
    {
        goto reselect;
    }
    else
    {
        cout << "See you again!";
    }
    return 0;
}