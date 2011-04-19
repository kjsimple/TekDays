import tekdays.TekEvent
import tekdays.TekUser
import tekdays.Sponsorship
import tekdays.Sponsor
 
class BootStrap {

    def init = { servletContext ->
        new TekUser(fullName: 'John Doe',
                    userName: 'jdoe', password: 't0ps3cr3t',
                    email: 'jdoe@johnsgroovyshop.com',
                    website: 'blog.johnsgroovyshop.com',
                    bio: 'John has been programming for over 40 years.').save()
        new TekUser(fullName: 'John Deere',
                    userName: 'tractorman', password: 't0ps3cr3t',
                    email: 'john.deere@portproducers.org',
                    website: 'www.peel.porkproducers.org',
                    bio: 'John is a top notch Perl programmer and a pretty good hand around the farm.').save()
        def event1 = new TekEvent(name: 'Gateway Code Camp',
                                  city: 'Saint Louis, MO',
                                  organizer: TekUser.findByFullName('John Doe'),
                                  venue: 'TBD',
                                  startDate: new Date('9/19/2009'),
                                  endDate: new Date('9/19/2009'),
                                  description: '''This conference will bring coders from 
across platforms, languages, and industries 
together for an exciting day of tips, tricks, 
and tech! Stay sharp! Stay at the top of your 
game!''')
        if (!event1.save()) {
            event1.errors.allErrors.each {error ->
                println "An error occured with event1: $error"
            }
        }
        event1.addToVolunteers(new TekUser(fullName: 'Sarah Martin',
                    userName: 'sarah', password: '54321',
                    email: 'sarah@martinworld.com',
                    website: 'www.martinworld.com',
                    bio: 'Web designer and Grails afficianado.'))
        event1.addToVolunteers(new TekUser(fullName: 'Bill Smith',
                    userName: 'Mr_Bill', password: '12345',
                    email: 'mrbill@email.com',
                    website: 'www.mrbillswebsite.com',
                    bio: 'Software developer, claymation artist.'))
        event1.addToRespondents('ben@grailsmail.com')
        event1.addToRespondents('zachary@linuxgurus.org')
        event1.addToRespondents('solomon@bootstrapwelding.com')
        event1.save()
        
        def event2 = new TekEvent(name: 'Perl Before Swine',
                                  city: 'Austin, MN',
                                  organizer: TekUser.findByFullName('John Deere'),
                                  venue: 'Spam Museum',
                                  startDate: new Date('9/1/2009'),
                                  endDate: new Date('9/1/2009'),
                                  description: '''Join the perl programmers of the Pork Producers 
of America and industries 
together for an exciting day of tips, tricks, 
and tech! Stay sharp! Stay at the top of your 
game!''')
        if (!event2.save()) {
            event2.errors.allErrors.each {error ->
                println "An error occured with event2: $error"
            }
        }
        def s1 = new Sponsor(name: 'Contegix',
                             website: 'contegix.com',
                             description: 'Beyond Managed Hosting for your Enterprise').save()
        def s2 = new Sponsor(name: 'Object computing Incorporated',
                             website: 'ociweb.com',
                             description: 'An OO Software Engineering Company').save()
        def sp1 = new Sponsorship(event: event1,
                                  sponsor: s1,
                                  contributionType: 'Other',
                                  description: 'Cool T-Shirts')
        def sp2 = new Sponsorship(event: event1,
                                  sponsor: s2,
                                  contributionType: 'Venue',
                                  description: 'Will be paying for the Moscone')
        s1.addToSponsorships(sp1)
        s1.save()
        s2.addToSponsorships(sp2)
        s2.save()
        event1.addToSponsorships(sp1)
        event1.addToSponsorships(sp2)
        event1.save()
    }
    def destroy = {
    }
}
