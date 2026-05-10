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

    IO.print("\n");
    int[] numbers3 = {3, 5, 2};
    insertionSort(numbers3);

    for (int num : numbers3) {
        IO.print(num + " ");
    }

    IO.print("\n");
    int[] numbers4 = {3, 5, 2};

    quickSort(numbers4, 0, numbers4.length - 1);

    for (int num : numbers4) {
        IO.print(num + " ");
    }


    IO.print("\n");
    int[] numbers5 = {3, 5, 2};

    mergeSort(numbers5, 0, numbers5.length - 1);

    for (int num : numbers5) {
        IO.print(num + " ");
    }


    IO.print("\n");
    int[] numbers6 = {3, 5, 2};

    heapSort(numbers6);

    for (int num : numbers6) {
        IO.print(num + " ");
    }

}

/**
 * バブルソート</br>
 * バブルソートは、隣接する要素を比較し、順序が逆の場合に交換することで、配列をソートするアルゴリズム
 * 
 * @param arr
 */
void bubleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

/**
 * 選択ソート</br>
 * 選択ソートは、配列を順番に走査し、最小の要素を見つけて、それを現在の位置に交換するアルゴリズム
 * 
 * @param arr
 */
void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        int minIdx = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIdx]) {
                minIdx = j;
            }
        }
        int temp = arr[minIdx];
        arr[minIdx] = arr[i];
        arr[i] = temp;
    }
}

/**
 * 挿入ソート</br>
 * 挿入ソートは、配列を部分的にソートされた状態に保ちながら、未ソートの要素を適切な位置に挿入していくアルゴリズム
 * 
 * @param arr
 */
void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        // 適切な位置にkeyを挿入
        arr[j + 1] = key;
    }
}

/**
 * クイックソート</br>
 * クイックソートは、分割統治法を使用して配列をソートするアルゴリズムで、ピボットを選択して配列を分割し、再帰的にソートする方法
 * 
 * @param arr
 * @param left
 * @param right
 */
void quickSort(int[] arr, int left, int right) {
    if (left >= right)
        return;

    // 1. 分割（パーティション）
    int pivot = arr[left + (right - left) / 2]; // 真ん中の要素をピボットにする
    int index = partition(arr, left, right, pivot);

    // 2. 左右のグループに対して再帰的に実行
    quickSort(arr, left, index - 1);
    quickSort(arr, index, right);
}

int partition(int[] arr, int left, int right, int pivot) {
    while (left <= right) {
        // ピボットより小さい間、左ポインタを進める
        while (arr[left] < pivot)
            left++;
        // ピボットより大きい間、右ポインタを戻す
        while (arr[right] > pivot)
            right--;

        // 見つかったら左右を入れ替える
        if (left <= right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    return left;
}


/**
 * マージソート</br>
 * マージソートは、分割統治法を使用して配列をソートするアルゴリズムで、配列を再帰的に分割し、整列された部分配列をマージしていく方法
 * 
 * @param arr
 * @param left
 * @param right
 */
// 1. 配列を分割していくメソッド（再帰）
void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = (left + right) / 2;

        // 左半分をさらに分割
        mergeSort(arr, left, mid);
        // 右半分をさらに分割
        mergeSort(arr, mid + 1, right);

        // 分割が終わったら、整列しながら合体
        merge(arr, left, mid, right);
    }
}

// 2. 2つの整列済み配列を「合体」させるメソッド
void merge(int[] arr, int left, int mid, int right) {
    // 一時的な作業用配列を作成
    int[] temp = new int[right - left + 1];

    int i = left; // 左側グループの先頭
    int j = mid + 1; // 右側グループの先頭
    int k = 0; // 作業用配列のインデックス

    // 両方のグループに要素がある間、小さい方を採用していく
    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j]) {
            temp[k++] = arr[i++];
        } else {
            temp[k++] = arr[j++];
        }
    }

    // 左側に残った要素を全部詰める
    while (i <= mid) {
        temp[k++] = arr[i++];
    }

    // 右側に残った要素を全部詰める
    while (j <= right) {
        temp[k++] = arr[j++];
    }

    // 作業用配列から元の配列に書き戻す
    for (int p = 0; p < temp.length; p++) {
        arr[left + p] = temp[p];
    }

}

/**
 * ヒープソート</br>
 * ヒープソートは、ヒープデータ構造を利用して配列をソートするアルゴリズムで、最大ヒープを構築してから、最大値を取り出して整列させる方法
 * 
 * @param arr
 */
void heapSort(int[] arr) {
    int n = arr.length;

    // 1. 最大ヒープを構築（配列をヒープ構造にする）
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(arr, n, i);
    }

    // 2. 1つずつ要素を取り出して整列させる
    for (int i = n - 1; i > 0; i--) {
        // 現在の根（最大値）を最後尾に入れ替える
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;

        // 残ったヒープを再構成する
        heapify(arr, i, 0);
    }
}

// ヒープ構造を維持するためのメソッド
void heapify(int[] arr, int n, int i) {
    int largest = i; // 親
    int left = 2 * i + 1; // 左の子
    int right = 2 * i + 2; // 右の子

    // 左の子の方が大きければ更新
    if (left < n && arr[left] > arr[largest])
        largest = left;

    // 右の子の方が大きければ更新
    if (right < n && arr[right] > arr[largest])
        largest = right;

    // 親より子の方が大きい場合、入れ替えて再帰的にチェック
    if (largest != i) {
        int swap = arr[i];
        arr[i] = arr[largest];
        arr[largest] = swap;

        heapify(arr, n, largest);
    }
}
