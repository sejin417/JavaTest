import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.*;
import javax.oss.fm.monitor.JVTAlarmMonitorHome;
import javax.rmi.*;
 
import java.util.*;
 
 
import org.apache.log4j.Logger;
 
import com.kt.bcn.common.entity.BcNResult;
 
import com.kt.bcn.common.ejb.*;
import com.kt.bcn.cm.ejb.*;
import com.kt.bcn.fm.monitor.ejb.*;
import com.kt.bcn.fm.monitor.entity.KTAlarmEventImpl;
 
import javax.oss.fm.monitor.*;
import javax.oss.pm.measurement.*;
import javax.oss.pm.threshold.*;
import com.kt.bcn.pm.measurement.ejb.*;
import com.kt.bcn.pm.threshold.ejb.*;
import com.kt.bcn.mmc.ejb.*;
 
 
public class EJBAliveTest
{
 
 
        public EJBAliveTest()
        {
                
        }
 
        String[][] ejbList = 
        {
                {"ejb/JVTCommonSession","EJB_CommonSession [common_session]"},                                    //1
                {"ejb/JVTConfigurationSession","EJB_ConfigSession [cm_session]"},                             //2
                {"ejb/JVTAlarmMonitorSession","EJB_AlarmMonitorSession [fm_session]"},                       //3
                {"ejb/JVTAlarmManagerSession","EJB_AlarmManagerSession [fm_manager]"},                        //4
                {"ejb/SMSManagerSession","EJB_SMSManagerSession [sms_manager]"},                               //5
                {"ejb/JVTPerformanceMonitorSessionImpl","EJB_PerformanceMonitorSessionImpl [pm_session]"},    //6
                {"ejb/JVTPerformanceEquipSessionImpl","EJB_PerformanceEquipSessionImpl [pm_equip]"},        //7
                {"ejb/JVTThresholdMonitorSessionImpl","EJB_ThresholdMonitorSessionImpl [tm_session]"},        //8
                {"ejb/JVTThresholdManagerSessionImpl","EJB_ThresholdManagerSessionImpl [tm_manager]"},        //9
                {"ejb/JVTTCAManagerSessionImpl","EJB_TCAManagerSessionImpl [tm_tca]"},                    //10
                {"ejb/JVTMmcSession","EJB_MmcSession [mmc_session]"}                                           //11
        };
 
        String[] mdbList = 
        {
        "EJB_ConfigMDB",                     //1
                "EJB_AlarmMDB",                      //2
                "EJB_PerformanceMonitorMDBImpl",     //3
                "EJB_ThresholdMonitorMDBImpl",       //4
                "EJB_MmcMDB"                        //5
        };
        
        public InitialContext getInitialContext()
        {
                InitialContext initial = null;
                try
                {                       
                        Properties prop = System.getProperties();
                        prop.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.appserv.naming.S1ASCtxFactory");
                        String url = "iiop://"+System.getProperty("server.ip")+":"+System.getProperty("iiop.port");
                        System.out.println("URL : "+url);
                        prop.put("java.naming.provider.url", url);
                        initial = new InitialContext(prop);
                }
                catch(Exception e)
                {
                        e.printStackTrace();
                }
                return initial;
        }
 
        
        public void testAlive() throws Exception
        {
                InitialContext initial = getInitialContext();
                System.out.println("\n------------------------------------------------------");         
                for( int i = 0 ; i < ejbList.length ; i++ )
                {
                        testEJB(initial, ejbList[i][0], ejbList[i][1]);
                }
                System.out.println("------------------------------------------------------\n");         
                
        }
        
        private void testEJB(InitialContext initial, String jndi, String ejbName) throws Exception
        {
                Object ref = null;
                
                try
                {
                        if( jndi.equals("ejb/JVTCommonSession"))
                        {
                                ref = initial.lookup(jndi);
                                JVTCommonSessionHome home = (JVTCommonSessionHome)PortableRemoteObject.narrow(ref, 
                                                                                        JVTCommonSessionHome.class);
                                JVTCommonSession remote = home.create();
                                System.out.println(ejbName + dummySpace(ejbName)+" = OOOO");
                        }
                        else if( jndi.equals("ejb/JVTConfigurationSession"))
                        {
                                ref = initial.lookup(jndi);
                                JVTConfigurationSessionHome home = (JVTConfigurationSessionHome)PortableRemoteObject.narrow(ref, 
                                                JVTConfigurationSessionHome.class);
                                JVTConfigurationSession remote = home.create();
                                System.out.println(ejbName + dummySpace(ejbName)+" = OOOO");
                        }
                        else if( jndi.equals("ejb/JVTAlarmMonitorSession"))
                        {
                                ref = initial.lookup(jndi);
                                JVTAlarmMonitorHome home = (JVTAlarmMonitorHome)PortableRemoteObject.narrow(ref, 
                                                JVTAlarmMonitorHome.class);
                                JVTAlarmMonitorSession remote = home.create();
                                System.out.println(ejbName + dummySpace(ejbName)+" = OOOO");
                        }
                        else if( jndi.equals("ejb/JVTAlarmManagerSession"))
                        {
                                ref = initial.lookup(jndi);
                                JVTAlarmManagerHome home = (JVTAlarmManagerHome)PortableRemoteObject.narrow(ref, 
                                                JVTAlarmManagerHome.class);
                                JVTAlarmManagerSession remote = home.create();
                                System.out.println(ejbName + dummySpace(ejbName)+" = OOOO");
                        }
                        else if( jndi.equals("ejb/SMSManagerSession"))
                        {
                                ref = initial.lookup(jndi);
                                SMSManagerSessionHome home = (SMSManagerSessionHome)PortableRemoteObject.narrow(ref, 
                                                SMSManagerSessionHome.class);
                                SMSManagerSession remote = home.create();
                                System.out.println(ejbName + dummySpace(ejbName)+" = OOOO");
                        }
                        else if( jndi.equals("ejb/JVTPerformanceMonitorSessionImpl"))
                        {
                                ref = initial.lookup(jndi);
                                JVTPerformanceMonitorHome home = (JVTPerformanceMonitorHome)PortableRemoteObject.narrow(ref, 
                                                JVTPerformanceMonitorHome.class);
                                JVTPerformanceMonitorSession remote = home.create();
                                System.out.println(ejbName + dummySpace(ejbName)+" = OOOO");
                        }
                        else if( jndi.equals("ejb/JVTPerformanceEquipSessionImpl"))
                        {
                                ref = initial.lookup(jndi);
                                JVTPerformanceEquipHome home = (JVTPerformanceEquipHome)PortableRemoteObject.narrow(ref, 
                                                JVTPerformanceEquipHome.class);
                                JVTPerformanceEquipSession remote = home.create();
                                System.out.println(ejbName + dummySpace(ejbName)+" = OOOO");
                        }
                        else if( jndi.equals("ejb/JVTThresholdMonitorSessionImpl"))
                        {
                                ref = initial.lookup(jndi);
                                JVTThresholdMonitorHome home = (JVTThresholdMonitorHome)PortableRemoteObject.narrow(ref, 
                                                JVTThresholdMonitorHome.class);
                                JVTThresholdMonitorSession remote = home.create();
                                System.out.println(ejbName + dummySpace(ejbName)+" = OOOO");
                        }
                        else if( jndi.equals("ejb/JVTThresholdManagerSessionImpl"))
                        {
                                ref = initial.lookup(jndi);
                                JVTThresholdManagerHome home = (JVTThresholdManagerHome)PortableRemoteObject.narrow(ref, 
                                                JVTThresholdManagerHome.class);
                                JVTThresholdManagerSession remote = home.create();
                                System.out.println(ejbName + dummySpace(ejbName)+" = OOOO");
                        }
                        else if( jndi.equals("ejb/JVTTCAManagerSessionImpl"))
                        {
                                ref = initial.lookup(jndi);
                                JVTTCAManagerHome home = (JVTTCAManagerHome)PortableRemoteObject.narrow(ref, 
                                                JVTTCAManagerHome.class);
                                JVTTCAManagerSession remote = home.create();
                                System.out.println(ejbName + dummySpace(ejbName)+" = OOOO");
                        }
                        else if( jndi.equals("ejb/JVTMmcSession"))
                        {
                                ref = initial.lookup(jndi);
                                JVTMmcSessionHome home = (JVTMmcSessionHome)PortableRemoteObject.narrow(ref, 
                                                JVTMmcSessionHome.class);
                                JVTMmcSession remote = home.create();
                                System.out.println(ejbName + dummySpace(ejbName)+" = OOOO");
                        }
                }
                catch(Exception e)
                {
                        //e.printStackTrace();
                        System.out.println(ejbName + dummySpace(ejbName)+" = XXXX  ---> " + e.getMessage());
                }
        }
        
        private String dummySpace(String ejbName)
        {
                int ejbNameMaxLength = 50;
                int ejbNameLength = ejbName.length(); 
                int cnt = ejbNameMaxLength-ejbNameLength;
                
                StringBuffer buf = new StringBuffer();
                for( int i = 0 ; i < cnt ; i++)
                {
                        buf.append(" ");
                }
                return buf.toString();
        }
        
        private void testMDB()
        {
                
        }
        
 
        /**
         * Main Method
         * @param args
         */
        public static void main(String args[])
        {
                
                System.out.println("# SERVER IP # : " + (String)args[0]);
                System.out.println("# IIOP PORT # : " + (String)args[1]);
                System.setProperty("server.ip",(String)args[0]);
                System.setProperty("iiop.port",(String)args[1]);
 
                try
                {
                        EJBAliveTest test = new EJBAliveTest();
                        test.testAlive();
                }
                catch(Exception e)
                {
                        //e.printStackTrace();
                        System.exit(0);
                }
                        
        }
 
 
}