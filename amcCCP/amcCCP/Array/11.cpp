#include <iostream>


using namespace std;

int maxArea(int *height, int size) {
    // Start typing your C/C++ solution below
    // DO NOT write int main() function
    int i = 0;
    int j = size - 1;

    int ret = 0;
    while (i < j) {
        int area = (j - i) * min(height[i], height[j]);
        ret = max(ret, area);

        if (height[i] <= height[j])
            i++;
        else
            j--;
    }

    return ret;
}

int main() {
    int N;
    cin >> N;

    int *array = new int[N];
    for (int i = 0; i < N; ++i) {
        cin >> array[i];
    }


    int max = maxArea(array, N);
    cout << max << endl;
    return 0;
}