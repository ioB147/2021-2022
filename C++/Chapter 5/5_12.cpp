#include <iostream>
using namespace std;
 
int main()
{
  int n, term1 = 0, term2 = 1, next = 0;
 
  cout << "Enter a positive number: ";
  cin >> n;
 
  // for first two numbers
  cout <<"Fibonacci Series: " <<term1 <<", " <<term2 <<", ";
 
  next = term1 + term2;
 
  while (next <= n)
  {
    cout << next << ", ";
 
    term1 = term2;
    term2 = next;
    next = term1 + term2;
  }
 
  return 0;
}