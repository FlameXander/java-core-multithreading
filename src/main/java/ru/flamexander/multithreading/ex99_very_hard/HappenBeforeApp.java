package ru.flamexander.multithreading.ex99_very_hard;

/**
 *     <p><B>The rules for happens-before are:</B>
 *
 *     <p><B>Program order rule.</B> Each action in a thread happens-before every action
 *     in that thread that comes later in the program order.
 *
 *     <p><B>Monitor lock rule.</B> An unlock on a monitor lock happens-before every
 *     subsequent lock on that same monitor lock.
 *
 *     <p><B>Volatile variable rule.</B> A write to a volatile field happens-before every
 *     subsequent read of that same field.
 *
 *     <p><B>Thread start rule.</B> A call to Thread.start on a thread happens-before
 *     every action in the started thread.
 *
 *     <p><B>Thread termination rule.</B> Any action in a thread happens-before any
 *     other thread detects that thread has terminated, either by successfully return
 *     from Thread.join or by Thread.isAlive returning false.
 *
 *     <p><B>Interruption rule.</B> A thread calling interrupt on another thread
 *     happens-before the interrupted thread detects the interrupt (eitherby having
 *     InterruptedException thrown, or invoking isInterrupted or interrupted).
 *
 *     <p><B>Finalizer rule.</B> The end of a constructor for an object happens-before
 *     the start of the finalizer for that object.
 *
 *     <p><B>Transitivity.</B> If A happens-before B, and B happens-before C, then A
 *     happens-before C.
 */
public class HappenBeforeApp {
}
