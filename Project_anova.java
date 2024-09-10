import java.text.DecimalFormat;
import java.util.Scanner;
public class Project_anova
{
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		DecimalFormat dm = new DecimalFormat("#.##");
		System.out.print("Enter value of k : ");
		int kn = inp.nextInt();
		System.out.print("Do your data sets have the same sample size? (Y/N) :: ");
		String YN = inp.next().toUpperCase();
		int[] nk = new int[kn];
		int kn1 = 1;
		int nk1 = 0;
		double [] sum_x  = new double[kn];
		double [] sum_x1 = new double[kn];
		double Td = 0.0;
		double s_ij = 0.0;
		double  sum_x2 = 0.0;
		int nk_sum = 0;
		double sum_ti = 0.0;
		while(!YN.equals("Y")&&!YN.equals("N")){
		           System.out.print("Do your data sets have the same sample size? (Y/N) :: ");
		           YN = inp.next().toUpperCase();
		}
		switch(YN){
		/*Y*/    case"Y":
		while(kn>=kn1){
		    System.out.print("Enter the population of the group "+kn1+": ");
		     nk[kn-1] = inp.nextInt();
		    nk1 = 1;
		    double x [] = new double [nk[kn-1]];
		    while(nk1<=nk[kn-1]){//n greater than 1
		        System.out.print("Enter population number "+kn1+"-"+nk1+": ");
		        x[nk[kn-1]-1] = inp.nextDouble();
		        sum_x[kn1-1] += x[nk[kn-1]-1];
		       
		        sum_x1[kn1-1] += Math.pow(x[nk[kn-1]-1],2);
		        nk1++;
		    }
		    System.out.println("T"+kn1+"= "+sum_x[kn1-1]); 
		    sum_x2 += Math.pow(sum_x[kn1-1],2);
	        kn1++;
		}
		for (int g = 0;g<sum_x1.length;g++) {
		     s_ij += sum_x1[g];
		}
		for (int g = 0;g<sum_x1.length;g++) {
		     Td += sum_x[g];
		}
		System.out.println("Sum Xij   = "+s_ij);
		System.out.println("T.. = "+Td);
		 nk1--;
		 kn1--;
		 double CT1 = (Math.pow(Td,2)/(nk1*kn1));
 		System.out.println("CT.= "+dm.format(CT1));
 		double SST1 = (s_ij-CT1);
 		System.out.println("SST = "+dm.format(SST1));
 		double SSA1 = (sum_x2/nk[kn-1])-CT1;
  		System.out.println("SSA = "+dm.format(SSA1));
  		double SSW1 = (SST1-SSA1);
  		System.out.println("SSW = "+dm.format(SSW1));
  		double MSA1 = SSA1/(kn-1);
  		System.out.println("MSA = "+dm.format(MSA1));
  		double MSW1 = SSW1/((nk1*kn1)-kn);
  		System.out.println("MSW = "+dm.format(MSW1));
  		System.out.println("Fcal = "+dm.format(MSA1/MSW1));
		        break;
	/*N*/	    case"N":
		    while(kn>=kn1){
		    System.out.print("Enter the population of the group "+kn1+": ");
		    nk[kn-1] = inp.nextInt();
		    nk1 = 1;
		    nk_sum += nk[kn-1];
		    double x [] = new double [nk[kn-1]];
		    while(nk1<=nk[kn-1]){//n greater than 1
		        System.out.print("Enter population number "+kn1+"-"+nk1+": ");
		        x[nk[kn-1]-1] = inp.nextDouble();
		        sum_x[kn1-1] += x[nk[kn-1]-1];
		       
		        sum_x1[kn1-1] += Math.pow(x[nk[kn-1]-1],2);
		        
	
		        nk1++;
		    }
		    System.out.println("T"+kn1+"= "+dm.format(sum_x[kn1-1])); 
		    sum_x2 += Math.pow(sum_x[kn1-1],2);
		    sum_ti += ((Math.pow(sum_x[kn1-1],2))/nk[kn-1]);
	        kn1++;
		}
		for (int g = 0;g<sum_x1.length;g++) {
		     s_ij += sum_x1[g];
		}
		for (int g = 0;g<sum_x1.length;g++) {
		     Td += sum_x[g];
		}
		System.out.println("Sum Xij   = "+dm.format(s_ij));
		System.out.println("T.. = "+Td);
		 nk1--;
		 kn1--;
		double CT2 = (Math.pow(Td,2)/nk_sum);
 		System.out.println("CT.= "+dm.format(CT2));
 		double SST2 = (s_ij-CT2);
 		System.out.println("SST = "+dm.format(SST2));
 		double SSA2 = sum_ti-CT2;
  		System.out.println("SSA = "+dm.format(SSA2));
  		double SSW2 = (SST2-SSA2);
  		System.out.println("SSW = "+dm.format(SSW2));
  		double MSA2 = SSA2/(kn-1);
  		System.out.println("MSA = "+dm.format(MSA2));
  		double MSW2 = SSW2/(nk_sum-kn);
  		System.out.println("MSW = "+dm.format(MSW2));
  		System.out.println("Fcal = "+dm.format(MSA2/MSW2));  
		        break;
		    default:System.out.println("X_X");
		            System.out.print("Are your n numbers the same number? (Y/N) :: ");
		            YN = inp.next().toUpperCase();
		            break;
	         }
	       } 
		  }
