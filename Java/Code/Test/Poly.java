import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Poly {

	public static void main(String[] args) {
		String tip = "������������ʽ,��ϵ����ָ����˳��,һ������ʽһ��,����\n 1 2 3 1 3 4"+ "\n 2 1 3 2 4 3";
		System.out.println(tip);
		Scanner scanner = new Scanner(System.in);
		Multinomial m1 = new Multinomial();
		Multinomial m2 = new Multinomial();
		try {
			String line1 = scanner.nextLine();
			String[] splits = line1.split(" ");
			if (splits.length % 2 != 0) {
				System.out.println("�����ʽ����");
				System.exit(0);
			}
			for (int i = 0; i < splits.length - 1; i += 2) {
				m1.addTerm(Double.parseDouble(splits[i]), Double.parseDouble(splits[i+1]));
			}
			String line2 = scanner.nextLine();
			splits = line2.split(" ");
			if (splits.length % 2 != 0) {
				System.out.println("�����ʽ����");
				System.exit(0);
			}
			for (int i = 0; i < splits.length - 1; i += 2) {
				m2.addTerm(Double.parseDouble(splits[i]), Double.parseDouble(splits[i+1]));
			}
		} catch(Exception e) {
			System.out.println("�����ʽ����");
			System.exit(0);
		}
		scanner.close();
		m1.sort();
		m2.sort();
		System.out.println("����ʽ1��" + m1);
		System.out.println("����ʽ2��" + m2);
		System.out.println("��������" + m1.minus(m2));
	}
	
	public static class Multinomial {
		private List<Term> terms;           //����ʽ����б�
		private boolean sorted;             //����Ƿ�������
		
		/**
		 * ��ʾ����ʽ��һ�����
		 *
		 */
		private class Term {
			public double coef = 0; //ϵ��
			public double exp = 0;  //ָ��
		}
		
		public Multinomial() {
			terms = new ArrayList<Poly.Multinomial.Term>();
		}
		
		/**
		 * ����
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
		 * ���һ��
		 * @param term
		 */
		public void addTerm(Term term) {
			if (term.coef != 0) {
				terms.add(term);
			}
		}
		
		/**
		 * ���һ��
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
		 * ����toString����,�������
		 */
		public String toString() {
			String s = "";
			for(Term term : terms) {
				s += "(" + term.coef + "," + term.exp + ") ";
			}
			return s;
		}
		
		/**
		 * ����
		 * @param other
		 */
		public Multinomial minus(Multinomial other) {
			//������
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