<template>
  <div>
    <new-meeting-form @added="addNewMeeting($event)"></new-meeting-form>

    <span v-if="meetings.length == 0">
               Brak zaplanowanych spotkań.
           </span>
    <h3 v-else>
      Zaplanowane zajęcia ({{ meetings.length }})
    </h3>

    <meetings-list :meetings="meetings"
                   :username="username"
                   @attend="addMeetingParticipant($event)"
                   @unattend="removeMeetingParticipant($event)"
                   @delete="deleteMeeting($event)"></meetings-list>
  </div>
</template>

<script>
    import NewMeetingForm from "./NewMeetingForm";
    import MeetingsList from "./MeetingsList";

    export default {
        components: {NewMeetingForm, MeetingsList},
        props: ['username'],
        data() {
            return {
                meetings: []
            };
        },
        methods: {
            addNewMeeting(meeting) {
                this.meetings.push(meeting);
                console.log(meeting);
                this.$http.post('meetings', meeting)
                     .then(response => {
                         // udało się
                     })
                     .catch(response => {
                         // nie udało sie
                     });

                this.$http.get('meetings')
                     .then(response => {
                         console.log(response);
                         // udało się
                     })
                     .catch(esponse => {
                          console.log("nie udało się");
                         // nie udało sie
                     });


            },
            addMeetingParticipant(meeting) {
                meeting.participants.push(this.username);

                this.$http.post('meetings/'+1+'/participants', {login:this.username, password:""})
                     .then(response => {
                         console.log("udało się zapisac");
                         // udało się
                     })
                     .catch(response => {
                          console.log("nie udało się zapisac");
                         // nie udało sie
                     });

            },
            removeMeetingParticipant(meeting) {
                meeting.participants.splice(meeting.participants.indexOf(this.username), 1);



            },
            deleteMeeting(meeting) {
                this.meetings.splice(this.meetings.indexOf(meeting), 1);
                 this.$http.delete('meetings/'+this.meetings.splice(this.meetings.indexOf(meeting), 1), meeting)
                     .then(response => {
                         console.log("usunieto spotkanie");
                         console.log("id to: " + this.meetings.splice(this.meetings.indexOf(meeting), 1));
                         // udało się
                     })
                     .catch(response => {
                          console.log("nie udało się usunac spotkania");
                          console.log("id to: " + this.meetings.splice(this.meetings.indexOf(meeting), 1));
                         // nie udało sie
                     });
            }
        }
    }
</script>
