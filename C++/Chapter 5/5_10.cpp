#include <iostream>
using namespace std;
 
int main() {
    int num,n,rev=0;
    
    cout<<"Enter number: ";
    cin >> num;

    n=num;
    while(n != 0){
        rev = rev*10 + n%10;
        n /= 10;
    }
     cout <<"Result: " <<num <<" is ";
    if(rev == num)
        cout << "a palindrome number";
    else
        cout << "not a Palindrome number";
    
    return 0;
}