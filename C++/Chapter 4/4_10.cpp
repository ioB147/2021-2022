#include <iostream>

using namespace std;
int main ()
{
    double num1, num2, num3;
    double smallest, middle, biggest;

    cout <<"Input three integers\n";
    cin >> num1 >> num2 >> num3;
    
    if ((num1>999999999 || num1<-999999999) || (num2>999999999 || num2<-999999999) || (num3>999999999 || num3<-999999999)) {
        cout <<"Not valid" <<endl;
    }else{
    if ((num1 < num2) && (num1 < num3))
    {
        smallest = num1;
        if (num2 > num3)
        {
            biggest = num2;
            middle = num3;
        }
    }
    if ((num1 < num2) && (num3 < num1))
    {
        smallest = num1;
        if (num2 < num3)
        {
            middle = num2;
            biggest = num3;
        }
    }
    if ((num1 > num2) && (num3 > num1))
    {
        middle = num1;
        if (num2 < num3)
        {
            smallest = num2;
            biggest = num3;
        }
    }
    if ((num1 < num2) && (num3 < num1))
    {
        middle = num1;
        if (num2 > num3)
        {
            biggest = num2;
            smallest = num3;
        }
    }
    if ((num1 > num2) && (num1 > num3))
    {
        biggest = num1;
        if (num3 > num2)
        {
            middle = num3;
            smallest = num2;
        }
    }

    if ((num1 > num2) && (num1 > num3))
    {
        biggest = num1;
        if (num2 > num3)
        {
            middle = num2;
            smallest = num3;
        }
    }

    cout << smallest << " " << middle << " " << biggest << endl;
    }
    return 1;
}