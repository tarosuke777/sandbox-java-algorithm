void main() {
    int[] numbers = {64, 34, 25, 12, 22, 11, 90};
    bubleSort(numbers);

    for (int num : numbers) {
        IO.print(num + " ");
    }
    IO.print("\n");
    int[] numbers2 = {64, 34, 25, 12, 22, 11, 90};
    selectionSort(numbers2);

    for (int num : numbers2) {
        IO.print(num + " ");
    }
}

void bubleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // swap arr[j] and arr[j+1]
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        int minIdx = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIdx]) {
                minIdx = j;
            }
        }
        // swap arr[i] and arr[minIdx]
        int temp = arr[minIdx];
        arr[minIdx] = arr[i];
        arr[i] = temp;
    }
}

