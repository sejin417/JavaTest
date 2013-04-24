import java.util.Calendar;

/*
 * (@)# CalenderTest.java
 * 
 * 2006. 7. 18
 *
 * ====================================================================
 *
 * WarePlus., Software License, Version 1.0
 *
 * Copyright (c) 2002-2004 Ware Plus.,
 * WarePlus  * All rights reserved.
 *
 * DON'T COPY OR REDISTRIBUTE THIS SOURCE CODE WITHOUT PERMISSION.
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL WarePlus OR ITS
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * For more information on this product, please see 
 * WarePlus
 *
 */

/**
 * @author Sejin
 * 
 */
public class CalenderTest {
	public String getCalander(){
		Calendar cal3 = Calendar.getInstance();

		String month = String.valueOf(cal3.get(Calendar.MONTH) + 1);
		String day = String.valueOf(cal3.get(Calendar.DATE));

		if (month.length() == 1){
			month = "0" + month;
		}

		if (day.length() == 1){
			day = "0" + day;
		}

		return month + day + "0000";
	}
	
    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        
        String lastTrafficDate = "200607191000";

        cal.set(Calendar.YEAR, Integer.parseInt(lastTrafficDate.substring(0,4)));
        cal.set(Calendar.MONTH, Integer.parseInt(lastTrafficDate.substring(4,6)));
        cal.set(Calendar.DATE, Integer.parseInt(lastTrafficDate.substring(6,8)));
        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(lastTrafficDate.substring(8,10)));
        cal.set(Calendar.MINUTE, Integer.parseInt(lastTrafficDate.substring(10,12)));
        cal.set(Calendar.SECOND, 0);

//        cal2.set(Calendar.SECOND, 0);

        String activity = String.valueOf(cal2.get(Calendar.DAY_OF_MONTH))
        + cal2.get(Calendar.HOUR_OF_DAY)
        + cal2.get(Calendar.MINUTE)
        + cal2.get(Calendar.SECOND);

        // --- display the activity
        System.out.println(activity);
        
        activity = "[" + cal.get(Calendar.MONTH) 
        + "/" + cal.get(Calendar.DAY_OF_MONTH) 
        + "/" + cal.get(Calendar.YEAR) 
        + " " 
        + cal.get(Calendar.HOUR_OF_DAY) 
        + ":" + cal.get(Calendar.MINUTE) 
        + ":" + cal.get(Calendar.SECOND);

        // --- display the activity
        System.out.println(activity);
        
        activity = "[" + cal2.get(Calendar.MONTH) 
        + "/" + cal2.get(Calendar.DAY_OF_MONTH) 
        + "/" + cal2.get(Calendar.YEAR) 
        + " " 
        + cal2.get(Calendar.HOUR_OF_DAY) 
        + ":" + cal2.get(Calendar.MINUTE) 
        + ":" + cal2.get(Calendar.SECOND);

        // --- display the activity
        System.out.println(activity);
        
        System.out.println( cal.getTimeInMillis());
        System.out.println( cal2.getTimeInMillis());
        System.out.println( cal2.getTimeInMillis() - cal.getTimeInMillis());
        
        System.out.println(new CalenderTest().getCalander());
    }
}
