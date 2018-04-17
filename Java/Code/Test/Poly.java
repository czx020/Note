import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Poly {

	public static void main(String[] args) {
		String tip = "输入两个多项式,按系数、指数的顺序,一个多项式一行,例如\n 1 2 3 1 3 4"+ "\n 2 1 3 2 4 3";
		System.out.println(tip);
		Scanner scanner = new Scanner(System.in);
		Multinomial m1 = new Multinomial();
		Multinomial m2 = new Multinomial();
		try {
			String line1 = scanner.nextLine();
			String[] splits = line1.split(" ");
			if (splits.length % 2 != 0) {
				System.out.println("输入格式有误");
				System.exit(0);
			}
			for (int i = 0; i < splits.length - 1; i += 2) {
				m1.addTerm(Double.parseDouble(splits[i]), Double.parseDouble(splits[i+1]));
			}
			String line2 = scanner.nextLine();
			splits = line2.split(" ");
			if (splits.length % 2 != 0) {
				System.out.println("输入格式有误");
				System.exit(0);
			}
			for (int i = 0; i < splits.length - 1; i += 2) {
				m2.addTerm(Double.parseDouble(splits[i]), Double.parseDouble(splits[i+1]));
			}
		} catch(Exception e) {
			System.out.println("输入格式有误");
			System.exit(0);
		}
		scanner.close();
		m1.sort();
		m2.sort();
		System.out.println("多项式1：" + m1);
		System.out.println("多项式2：" + m2);
		System.out.println("相减结果：" + m1.minus(m2));
	}
	
	public static class Multinomial {
		private List<Term> terms;           //多项式项的列表
		private boolean sorted;             //标记是否已排序
		
		/**
		 * 表示多项式的一项的类
		 *
		 */
		private class Term {
			public double coef = 0; //系数
			public double exp = 0;  //指数
		}
		
		public Multinomial() {
			terms = new ArrayList<Poly.Multinomial.Term>();
		}
		
		/**
		 * 排序
		 */
		public void sort() {
			if (sorted) {
				return ;
			}
			Term temp = null;
			for (int i = 0; i < terms.size(); i++) {
				double min = terms.get(i).exp;
				int min_index = i;
				for (int j = i + 1; j < terms.size(); j++) {
					if(terms.get(j).exp < min) {
						min = terms.get(j).exp;
						min_index = j;
					}
				}
				if (min_index != i) {
					temp = terms.get(i);
					terms.set(i, terms.get(min_index));
					terms.set(min_index, temp);
				}
			}
			sorted = true;
		}
		
		/**
		 * 添加一项
		 * @param term
		 */
		public void addTerm(Term term) {
			if (term.coef != 0) {
				terms.add(term);
			}
		}
		
		/**
		 * 添加一项
		 * @param coef
		 * @param exp
		 */
		public void addTerm(double coef, double exp) {
			Term term = new Term();
			term.coef = coef;
			term.exp = exp;
			this.terms.add(term);
		}
		
		/**
		 * 重载toString函数,用于输出
		 */
		public String toString() {
			String s = "";
			for(Term term : terms) {
				s += "(" + term.coef + "," + term.exp + ") ";
			}
			return s;
		}
		
		/**
		 * 减法
		 * @param other
		 */
		public Multinomial minus(Multinomial other) {
			//先排序
			if (!this.sorted) {
				this.sort();
			}
			if (!other.sorted) {
				other.sort();
			}
			Multinomial result = new Multinomial();
			int index1 = 0;
			int index2 = 0;
			
			while (index1 < this.terms.size() && index2 < other.terms.size()) {
				Term term1 = this.terms.get(index1);
				Term term2 = other.terms.get(index2);
				if(term1.exp == term2.exp) {			
					result.addTerm(term1.coef-term2.coef, term1.exp);
					index1 += 1;
					index2 += 1;
				} else if (term1.exp < term2.exp) {
					result.addTerm(term1.coef, term1.exp);
					index1 += 1;
				} else {
					result.addTerm(term2.coef, term2.exp);
					index2 += 1;
				}
				
			}
			
			for (int i = index1; i < this.terms.size(); i++) {
				result.addTerm(this.terms.get(i).coef, this.terms.get(i).exp);
			}
			
			for (int i = index2; i < other.terms.size(); i++) {
				result.addTerm(other.terms.get(i).coef, other.terms.get(i).exp);
			}
			
			return result;
		}
	}
}