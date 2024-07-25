class Solution {
    private void merge(int arr[],int s,int e){
        int mid = s + (e - s) / 2;
        int left[] = Arrays.copyOfRange(arr, s, mid + 1);  
        int right[] = Arrays.copyOfRange(arr, mid + 1, e + 1);  


        int i=0,j=0,k=s;
        while(i<left.length && j <right.length){
            if(left[i] > right[j]) arr[k++] =right[j++];
            else arr[k++] = left[i++];
        }
        while(i<left.length) arr[k++] = left[i++];
        while(j<right.length)arr[k++] = right[j++];
        return;
    }
    private void sort(int arr[],int s,int e){
        if(s>=e) return;
        int mid = s+(e-s)/2;
        sort(arr,s,mid);
        sort(arr,mid+1,e);
        merge(arr,s,e);
        return;
    }
    public int[] sortArray(int[] nums) {
        sort(nums,0,nums.length-1);
        return nums;
    }
}
