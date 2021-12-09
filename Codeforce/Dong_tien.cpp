#include <iostream>
#include <algorithm>
#include <stdio.h>
#include <math.h>
#include <bits/stdc++.h>

using namespace std;

long long n, p, u, v, x, s, t;
long long h[100][100], k[100][100];

long long C(long long k, long long n) {
    if (k == 0 || k == n) return 1;
    if (k == 1) return n;
    return C(k - 1, n - 1) + C(k, n - 1);
}

int main () {   
    cin >> n >> p;
    for ( int i = 1; i <= n; i++) {
        cin >> x;
        if ( x % 2 == 0 ) {
            u++; 
        }
        else {
            v++;
        }
    }
    s = 0;
    for ( int i = 0; i <= u; i++) {
        if ( h[i][u] == 0 ) {
            if ( u - i != i ) {
                t = t + 2 * C(i, u);
                h[i][u] = 1; h[u - i][u] = 1;
            }
            else {
                t = t + C(i, u);
                t = t % (1000000000 + 7);
                break;
            }
            t = t % (1000000000 + 7);
        }
        else {
            break;
        }
    }
    if ( p == 0 ) {
        for ( int j = 0; j <= v; j = j + 2) {
            if ( k[j][v] == 0 ) {
                if ( v - j != j ) {
                    if ( (v - j) % 2 == 0 ) {
                        s = s + 2 * (t * C(j, v));
                    }
                    else {
                        s = s + (t * C(j, v));
                    }
                    k[j][v] = 1; k[v - j][v] = 1;
                }
                else {
                    s = s + (t * C(j, v));
                    s = s % (1000000000 + 7);
                    break;
                }
                s = s % (1000000000 + 7);
            }
            else {
                break;
            }
        }
    }
    else {
        for ( int j = 1; j <= v; j = j + 2) {
            if ( k[j][v] == 0 ) {
                if ( v - j != j ) {
                    if ( (v - j) % 2 == 1 ) {
                        s = s + 2 * (t * C(j, v));
                    }
                    else {
                        s = s + (t * C(j, v));
                    }
                    k[j][v] = 1; k[v - j][v] = 1;
                }
                else {
                    s = s + (t * C(j, v));
                    s = s % (1000000000 + 7);
                    break;
                }
                s = s % (1000000000 + 7);
            }
            else {
                break;
            }
        }
    }
    cout << s;
}