#include<iostream>
using namespace std;

int main()
{
     int num1, num2, temp;

     cout << "Type value of number 1 : ";
     cin >> num1;
     
     cout << "Type value of number 2 : ";
     cin >> num2;     

     temp = num1;
     num1 = num2;
     num2 = temp;

     cout << "After swapping values" <<endl;
     cout << "Value of number 1 : " << num1 << endl ;
     
     cout << "Value of number 2 : "<< num2;
     
     return 0;
}