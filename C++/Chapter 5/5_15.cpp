#include <iostream>
using namespace std;
 
int main() {

    int num,i,largest=1;

    cout << "Enter a positive integer n= "; cin >> num;
    if (num>0)
    {
        i = 1;
        while (i < num)
        {
            i++;
            if (num % i == 0)
            {
                if (i % 2 != 0)
                largest = i;
            }
        }
            cout << largest;
    }
    else cout <<"N";
   
    return 0;
}