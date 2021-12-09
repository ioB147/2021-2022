#include <iostream>
using namespace std;
 
int main() {
    string s;
    int t,n;
    cin >> t;
    while (t>0) {
        t--;
        cin >> s;
        n = s.size();
        if (n > 10) {
            cout << s[0] << n - 2 << s[n - 1] << endl;
        }
        else cout << s << endl;
    }
    return 0;
}