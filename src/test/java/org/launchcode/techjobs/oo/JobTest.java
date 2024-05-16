package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Web Developer", new Employer("LaunchCode"), new Location("StL"),
                new PositionType("Back-end developer"), new CoreCompetency("Java"));

        assertTrue(job instanceof Job);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Web Developer", job.getName());
        assertEquals("LaunchCode", job.getEmployer().getValue());
        assertEquals("StL", job.getLocation().getValue());
        assertEquals("Back-end developer", job.getPositionType().getValue());
        assertEquals("Java", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Web Developer", new Employer("LaunchCode"), new Location("StL"),
                new PositionType("Back-end developer"), new CoreCompetency("Java"));
        Job job2 = new Job("Web Developer", new Employer("LaunchCode"), new Location("StL"),
                new PositionType("Back-end developer"), new CoreCompetency("Java"));

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Web Developer", new Employer("LaunchCode"), new Location("StL"),
                new PositionType("Back-end developer"), new CoreCompetency("Java"));
        String jobString = job.toString();
        assertEquals('\n', jobString.charAt(0));
        assertEquals('\n', jobString.charAt(jobString.length() - 1));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Web Developer", new Employer("LaunchCode"), new Location("StL"),
                new PositionType("Back-end developer"), new CoreCompetency("Java"));
        String jobString = job.toString();
        String expected = "\nID: " + job.getId() + "\n" +
                "Name: Web Developer\n" +
                "Employer: LaunchCode\n" +
                "Location: StL\n" +
                "Position Type: Back-end developer\n" +
                "Core Competency: Java\n";
        assertEquals(expected, jobString);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("", new Employer(""), new Location("StL"),
                new PositionType("Back-end developer"), new CoreCompetency("Java"));
        String jobString = job.toString();
        String expected = "\nID: " + job.getId() + "\n" +
                "Name: Data not available\n" +
                "Employer: Data not available\n" +
                "Location: StL\n" +
                "Position Type: Back-end developer\n" +
                "Core Competency: Java\n";
        assertEquals(expected, jobString);
    }

    @Test
    public void testToStringHandlesJobWithOnlyId() {
        Job job = new Job();
        String jobString = job.toString();
        String expected = "OOPS! This job does not seem to exist.";
        assertEquals(expected, jobString);
    }


}
