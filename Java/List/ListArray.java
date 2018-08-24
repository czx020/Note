package chapter02;

public class ListArray<T extends Comparable<T>> implements List<T> {

	/* 算法2-1：定义顺序表数据类型 */
	private int capacity = 0;
	private int size = 0;
	private Object elements[];


	public ListArray(Object elements[]) {

		this.capacity = (elements.length/10+1)*10;
		this.elements = new Object[this.capacity];
		for (int i = 0; i < elements.length; i++) {
			this.elements[i] = elements[i];
		}
		this.size = elements.length;
	}

	/* 算法2-2创建空顺序表方法 */
	public ListArray(int capacity) {
		this.capacity = capacity;
		this.elements = new Object[this.capacity];
		this.size = 0;
	}

	private boolean checkBounds(int index) throws IndexOutOfBoundsException{
		if ((index < 0) || (index > this.size)) /* 判断输入的位置index是否合法 */ {
			throw new IndexOutOfBoundsException();
		}
		return true;
	}


	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	/*算法2-5 查找给定元素值element*/
	public int search(T data) {
		int i = 0;
		while ((i < this.size) && (this.elements[i] != data))
			/* 当位置i的元素不等于x时，继续向下比对 */
			i = i + 1;
		if (i == this.size) /* 判断比对位置是否已经超出地址范围 */
			return (-1); /* 返回查找不成功的标志 */
		else
			return (i); /* 返回查找到的给定值所在下标 */
	}

	public boolean contains(T data) {
		return search(data) != -1;
	}

	public void clear() {
		this.size = 0;
	}

	public T get(int index) throws IndexOutOfBoundsException{
		if (checkBounds(index)){
			return (T) this.elements[index];
		}
		return null;
	}

	public boolean insertAt(int index, T data) {
		if(checkBounds(index)){
			for (int i = this.size - 1; i >= index + 1; i--) { /* index位置以及之后所有元素后移一位 */
				this.elements[i + 1] = this.elements[i];
			}
			this.elements[index] = data;
			size++;
			return  true;
		}
		return false;
	}

	public boolean insertAfter(int index, T data) {
		return this.insertAt(index+1,data);

	}

	
	/*算法2-4 删除第index个元素*/
	public boolean remove(int index) {
		int j;
		if ((index < 0) || (index > this.size - 1)) /* 判断要删除元素的位置是否合法 */ {
			System.out.printf("删除位置不合法！");
			return false; /* 返回删除失败的标志 */
		}
		/* index+1位置以及之后所有元素前移一位 */
		for (j = index + 1; j >= this.size - 1; j++) {
			this.elements[j - 1] = this.elements[j];
		}
		this.size = this.size - 1; /* 顺序表元素个数减1 */
		return true; /* 返回删除成功的标志 */
	}

	public boolean remove(T data) {
		int index = search(data);
		if(index>0){
			return remove(index);
		}
		return false;
	}


	/*算法2-6 顺序表的合并*/
	public ListArray<T> merge(ListArray<T> list) {
		int index = 0, listIndex = 0, mergedListIndex = 0;
		ListArray<T> mergedList = new ListArray<T>(this.capacity + list.capacity);
		while ((index < this.size) && (listIndex < list.size()))
			/* 当i和j都在合理范围内时 */
			if (this.get(index).compareTo(list.get(listIndex)) < 0) {
				mergedList.elements[mergedListIndex] = this.elements[index];
				index++;
				mergedListIndex++;
			} else {
				mergedList.elements[mergedListIndex] = list.elements[listIndex];
				listIndex++;
				mergedListIndex++;
			}
		if (index < this.size) /* 如果i还在合理范围内，即还有剩余元素 */
			while (index < this.size) /* 将当前列表中的所有剩余元素放入mergedList中 */ {
				mergedList.elements[mergedListIndex] = this.elements[index];
				index++;
				mergedListIndex++;
			}
		else
			while (listIndex < list.size) /* 将anotherList中的所有剩余元素放入mergedList中 */ {
				mergedList.elements[mergedListIndex] = list.elements[listIndex];
				listIndex++;
				mergedListIndex++;
			}
		mergedList.size = mergedListIndex; /*mergedList中的元素总数 */
		return (mergedList); /* 返回mergedList */
	}

	public void display() {
		System.out.print("list is:[");
		for (int i = 0; i < this.size; i++) {
			T value = this.get(i);
			if (value != null) {
				System.out.print(value.toString());
			} else {
				System.out.print("null");
			}

			if (i != (this.size - 1)) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}



	public static void main(String[] args) {
		ListArray<Integer> sList = new ListArray<Integer>(10);
		sList.insertAt(0, 0);
		System.out.println(sList.size());
		sList.insertAfter(0, 1);
		System.out.println("list after  [insertBefore(0,1)] call!");
		sList.display();
		sList.insertAfter(1, 2);
		System.out.println("list after [insertAfter(0,2)] call!");
		sList.display();
		System.out.println("***************************************");
		ListArray<Integer> listA = new ListArray<Integer>( new Integer[]{2, 4, 4, 6});
		ListArray<Integer> listB = new ListArray<Integer>( new Integer[]{1, 3, 3, 5});
		ListArray<Integer> listMerged = listA.merge(listB);
		System.out.println("list A");
		listA.display();
		System.out.println("list B");
		listB.display();
		System.out.println("list merged");
		listMerged.display();


		return;
	}


}
