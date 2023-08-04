let nav = 0;
let clicked = null;
let events = localStorage.getItem('events') ? JSON.parse(localStorage.getItem('events')) : [];

const calendar = document.getElementById('calendar');
const newEventModal = document.getElementById('newEventModal');
const deleteEventModal = document.getElementById('deleteEventModal');
const backDrop = document.getElementById('modalBackDrop');
const eventTitleInput = document.getElementById('eventTitleInput');
const weekdays = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
let selectedMeal=null;
function openModal(date) {
 
  clicked = date;
    

  const eventForDay = events.find(e => e.date === clicked);
  
  if (eventForDay) {
   
    document.getElementById('eventText').innerText =  eventForDay.title;
      document.getElementById('eventMeal').innerText= eventForDay.meal;
    deleteEventModal.style.display = 'block';
  } else {
    newEventModal.style.display = 'block';
  }

  backDrop.style.display = 'block';
   const formattedDate = new Date(date).toLocaleDateString('en-us', {
    year: 'numeric',
    month: '2-digit',
    day: '2-digit',
  });
  
  document.getElementById('selectedDateInput').value = formattedDate;
  document.getElementById('selectedDateHidden').value = formattedDate;
  document.getElementById('eventTitleInput').value = svRecipeID;
   document.getElementById('eventMealInput').value=selectedMeal;
}



function load() {
  const dt = new Date();

  if (nav !== 0) {
    dt.setMonth(new Date().getMonth() + nav);
  }

  const day = dt.getDate();
  const month = dt.getMonth();
  const year = dt.getFullYear();

  const firstDayOfMonth = new Date(year, month, 1);
  const daysInMonth = new Date(year, month + 1, 0).getDate();
  
  const dateString = firstDayOfMonth.toLocaleDateString('en-us', {
    weekday: 'long',
    year: 'numeric',
    month: 'numeric',
    day: 'numeric',
  });
  const paddingDays = weekdays.indexOf(dateString.split(', ')[0]);

  document.getElementById('monthDisplay').innerText = 
    `${dt.toLocaleDateString('en-us', { month: 'long' })} ${year}`;

  calendar.innerHTML = '';

  for(let i = 1; i <= paddingDays + daysInMonth; i++) {
    const daySquare = document.createElement('div');
    daySquare.classList.add('day');

    const dayString = `${month + 1}/${i - paddingDays}/${year}`;

    if (i > paddingDays) {
      daySquare.innerText = i - paddingDays;
      const eventForDay = events.find(e => e.date === dayString);

      if (i - paddingDays === day && nav === 0) {
        daySquare.id = 'currentDay';
      }
        
      if (eventForDay && userID) {
        const eventDiv = document.createElement('div');
        eventDiv.classList.add('event');
        eventDiv.innerText = eventForDay.title;
        daySquare.appendChild(eventDiv);
      }

      daySquare.addEventListener('click', () => openModal(dayString));
    } else {
      daySquare.classList.add('padding');
    }

    calendar.appendChild(daySquare);    
  }
}

function closeModal() {
  eventTitleInput.classList.remove('error');
  newEventModal.style.display = 'none';
  deleteEventModal.style.display = 'none';
  backDrop.style.display = 'none';
  eventTitleInput.value = '';
  clicked = null;
  load();
}

function saveEvent() {
    const selectedRecipeID = eventTitleInput.value;
  const selectedRecipeName = eventTitleInput.options[eventTitleInput.selectedIndex].text;
  const selectedMealInput= document.getElementById('eventMealInput');
  selectedMeal=selectedMealInput.value;
   if (selectedRecipeID) {
    eventTitleInput.classList.remove('error');

    events.push({
      date: clicked,
      title: selectedRecipeName,
      recipeID: selectedRecipeID,
       meal: selectedMeal
    });
     document.getElementById('svRecipeIDHidden').value = selectedRecipeID;
    document.getElementById('svRecipeNameHidden').value = selectedRecipeName;

    // Set the value of the hidden input field with the svRecipeID
   
    // Submit the form to the servlet
    const form = document.getElementById('eventForm');
    form.submit();

    localStorage.setItem('events', JSON.stringify(events));
    closeModal();
  } else {
    eventTitleInput.classList.add('error');
  }
}
document.getElementById('addMoreButton').addEventListener('click', () => {
  // Get the selected date from the global variable "clicked"
  if (clicked) {
    // Open the new event modal
    newEventModal.style.display = 'block';
    backDrop.style.display = 'block';
  }
});

function addMoreEvent(date){
    closeModal();
    clicked = date;

  // Check if an event exists for the selected date
  const eventForDay = events.find(e => e.date === clicked);

  if (eventForDay) {
    // If an event exists, display the delete event modal
    document.getElementById('eventText').innerText = eventForDay.title;
    deleteEventModal.style.display = 'block';
  } else {
    // If no event exists, display the new event modal
    newEventModal.style.display = 'block';
  }

  backDrop.style.display = 'block';
    
    
}


function deleteEvent() {
  events = events.filter(e => e.date !== clicked);
  localStorage.setItem('events', JSON.stringify(events));
  closeModal();
}

function initButtons() {
  document.getElementById('nextButton').addEventListener('click', () => {
    nav++;
    load();
  });

  document.getElementById('backButton').addEventListener('click', () => {
    nav--;
    load();
  });

  document.getElementById('saveButton').addEventListener('click', saveEvent);
  document.getElementById('cancelButton').addEventListener('click', closeModal);
  document.getElementById('deleteButton').addEventListener('click', deleteEvent);
  document.getElementById('closeButton').addEventListener('click', closeModal);
  document.getElementById('addMoreButton').addEventListener('click', addMoreEvent);
 
}

initButtons();
load();
