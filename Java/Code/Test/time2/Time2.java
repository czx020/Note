package time2;
public class Time2 {
    private int hour;      // 0-23
    private int minute;    // 0-59
    private int second;    // 0-59

    public Time2( ) { setTime( 0, 0, 0 ); }
                    //{ this(0, 0, 0); }

    public Time2( int h ) { setTime( h, 0, 0 ); }
                    //{ this(h, 0, 0); }

    public Time2( int h, int m ) { setTime( h, m, 0 ); }
                    //{ this(h, m, 0); }

    public Time2( int h, int m, int s ) { setTime( h, m, s ); }
                    //{ this(h, m, s); }

    public Time2( Time2 time ) {
        setTime( time.hour, time.minute, time.second ); }

    public void setTime( int h, int m, int s ) {
        hour = ( ( h >= 0 && h < 24 ) ? h : 0 );
        minute = ( ( m >= 0 && m < 60 ) ? m : 0 );
        second = ( ( s >= 0 && s < 60 ) ? s : 0 ); }

    public int getHour( ) { return hour; }

    public int getMinute( ) { return minute; }

    public int getSecond( ) { return second; }

    // Convert to universal time
    public String toUniversalString( ) {
        return String.format( "%02d:%02d:%02d",
        getHour(), getMinute(), getSecond() );
    }

    // Convert to standard time
    public String toString( ) {
      return String.format( "%02d:%02d:%02d %s",
        ( ( getHour() == 0 || getHour() == 12 ) ? 12: getHour()%12 ),
        getMinute(), getSecond(), ( getHour() < 12 ? "AM" : "PM" ) );
    }
}
