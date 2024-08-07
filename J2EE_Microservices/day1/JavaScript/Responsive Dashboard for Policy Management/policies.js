document.querySelector('.sort').addEventListener('click', function() {
  const list=document.getElementById('policyList');
  const items=Array.from(list.querySelectorAll('.list-items-to-sort'));
  items.sort((a, b) => {
    const titleA=a.querySelector('h5').textContent.trim();
    const titleB=b.querySelector('h5').textContent.trim();
    return titleA.localeCompare(titleB);
  });
  items.forEach(item=>list.removeChild(item));
  items.forEach(item=>list.appendChild(item));
});