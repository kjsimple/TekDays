package tekdays

import grails.test.*

class TekEventTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testSomething() {
        def tekEvent = new TekEvent(name: 'Groovy one',
                                    city: 'San Francisco, CA',
                                    organizer: [fullName: 'John Doe'] as TekUser,
                                    venue: 'Moscone Center',
                                    startDate: new Date('6/2/2009'),
                                    endDate: new Date('6/5/2009'),
                                    description: 'This conference will cover all...')
        assertEquals 'Groovy one, San Francisco, CA', tekEvent.toString()
    }
}
